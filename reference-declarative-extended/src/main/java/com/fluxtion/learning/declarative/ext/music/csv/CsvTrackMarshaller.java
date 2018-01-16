package com.fluxtion.learning.declarative.ext.music.csv;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.declarative.ext.music.csv.AsciiAnyCharMatcher_1;
import com.fluxtion.learning.declarative.ext.music.csv.AsciiAnyCharMatcher_0;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.learning.declarative.ext.music.csv.TrackStreamCsvMarshaller7;
import com.fluxtion.learning.declarative.ext.music.TrackPublisher;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;

public class CsvTrackMarshaller implements EventHandler, BatchHandler, Lifecycle {

//Node declarations
    private final AsciiAnyCharMatcher_1 asciiAnyCharMatcher_1_17 = new AsciiAnyCharMatcher_1();
    private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_16 = new AsciiAnyCharMatcher_0();
    private final Csv2ByteBuffer csv2ByteBuffer_1 = new Csv2ByteBuffer();
    private final Csv2ByteBuffer csv2ByteBuffer_3 = new Csv2ByteBuffer();
    private final Csv2ByteBuffer csv2ByteBuffer_5 = new Csv2ByteBuffer();
    private final Csv2ByteBuffer csv2ByteBuffer_7 = new Csv2ByteBuffer();
    private final Csv2ByteBuffer csv2ByteBuffer_9 = new Csv2ByteBuffer();
    private final Csv2ByteBuffer csv2ByteBuffer_11 = new Csv2ByteBuffer();
    private final Csv2Double csv2Double_13 = new Csv2Double();
    private final TrackStreamCsvMarshaller7 trackStreamCsvMarshaller7_15 = new TrackStreamCsvMarshaller7();
    public final TrackPublisher tracks = new TrackPublisher(trackStreamCsvMarshaller7_15);
//Dirty flags
    private boolean isDirty_asciiAnyCharMatcher_1_17 = false;
    private boolean isDirty_csv2ByteBuffer_1 = false;
    private boolean isDirty_csv2ByteBuffer_5 = false;
    private boolean isDirty_csv2ByteBuffer_9 = false;
    private boolean isDirty_csv2Double_13 = false;
    private boolean isDirty_asciiAnyCharMatcher_0_16 = false;
    private boolean isDirty_csv2ByteBuffer_3 = false;
    private boolean isDirty_csv2ByteBuffer_7 = false;
    private boolean isDirty_csv2ByteBuffer_11 = false;
    private boolean isDirty_trackStreamCsvMarshaller7_15 = false;
//Filter constants

    public CsvTrackMarshaller() {
        csv2ByteBuffer_1.fieldNumber = (int) 0;
        csv2ByteBuffer_1.headerLines = (int) 1;
        csv2ByteBuffer_1.eolNotifier = asciiAnyCharMatcher_1_17;
        csv2ByteBuffer_1.delimiterNotifier = asciiAnyCharMatcher_0_16;
        csv2ByteBuffer_3.fieldNumber = (int) 1;
        csv2ByteBuffer_3.headerLines = (int) 1;
        csv2ByteBuffer_3.eolNotifier = asciiAnyCharMatcher_1_17;
        csv2ByteBuffer_3.delimiterNotifier = asciiAnyCharMatcher_0_16;
        csv2ByteBuffer_5.fieldNumber = (int) 2;
        csv2ByteBuffer_5.headerLines = (int) 1;
        csv2ByteBuffer_5.eolNotifier = asciiAnyCharMatcher_1_17;
        csv2ByteBuffer_5.delimiterNotifier = asciiAnyCharMatcher_0_16;
        csv2ByteBuffer_7.fieldNumber = (int) 3;
        csv2ByteBuffer_7.headerLines = (int) 1;
        csv2ByteBuffer_7.eolNotifier = asciiAnyCharMatcher_1_17;
        csv2ByteBuffer_7.delimiterNotifier = asciiAnyCharMatcher_0_16;
        csv2ByteBuffer_9.fieldNumber = (int) 4;
        csv2ByteBuffer_9.headerLines = (int) 1;
        csv2ByteBuffer_9.eolNotifier = asciiAnyCharMatcher_1_17;
        csv2ByteBuffer_9.delimiterNotifier = asciiAnyCharMatcher_0_16;
        csv2ByteBuffer_11.fieldNumber = (int) 5;
        csv2ByteBuffer_11.headerLines = (int) 1;
        csv2ByteBuffer_11.eolNotifier = asciiAnyCharMatcher_1_17;
        csv2ByteBuffer_11.delimiterNotifier = asciiAnyCharMatcher_0_16;
        csv2Double_13.fieldNumber = (int) 6;
        csv2Double_13.headerLines = (int) 1;
        csv2Double_13.delimiterNotifier = asciiAnyCharMatcher_0_16;
        trackStreamCsvMarshaller7_15.csvSrc_0 = csv2ByteBuffer_1;
        trackStreamCsvMarshaller7_15.csvSrc_1 = csv2ByteBuffer_3;
        trackStreamCsvMarshaller7_15.csvSrc_2 = csv2ByteBuffer_5;
        trackStreamCsvMarshaller7_15.csvSrc_3 = csv2ByteBuffer_7;
        trackStreamCsvMarshaller7_15.csvSrc_4 = csv2ByteBuffer_9;
        trackStreamCsvMarshaller7_15.csvSrc_5 = csv2ByteBuffer_11;
        trackStreamCsvMarshaller7_15.csvSrc_6 = csv2Double_13;
    }

    @Override
    public void onEvent(com.fluxtion.runtime.event.Event event) {
        switch (event.eventId()) {
            case (CharEvent.ID): {
                CharEvent typedEvent = (CharEvent) event;
                handleEvent(typedEvent);
                break;
            }
        }

    }

    public void handleEvent(CharEvent typedEvent) {
        FilteredHandlerInvoker invoker = dispatchIntMapCharEvent.get(typedEvent.filterId());
        if (invoker != null) {
            invoker.invoke(typedEvent);
            afterEvent();
            return;
        }
        //Default, no filter methods
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        afterEvent();
    }

//int filter maps
    private final Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchIntMapCharEvent = initdispatchIntMapCharEvent();

//String filter maps
    private Int2ObjectOpenHashMap<FilteredHandlerInvoker> initdispatchIntMapCharEvent() {
        Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchMap = new Int2ObjectOpenHashMap<>();
        dispatchMap.put(10, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_10((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(44, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_44((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(45, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_45((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(46, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_46((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(48, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_48((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(49, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_49((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(50, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_50((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(51, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_51((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(52, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_52((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(53, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_53((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(54, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_54((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(55, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_55((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(56, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_56((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(57, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_57((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        dispatchMap.put(0, new FilteredHandlerInvoker() {

            @Override
            public void invoke(Object event) {
                handle_CharEvent_NoFilter((com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
            }
        });
        return dispatchMap;
    }

    private void handle_CharEvent_10(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_asciiAnyCharMatcher_1_17 = asciiAnyCharMatcher_1_17.onChar_newLine(typedEvent);
        if (isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEol(asciiAnyCharMatcher_1_17);
            csv2ByteBuffer_3.onEol(asciiAnyCharMatcher_1_17);
            csv2ByteBuffer_5.onEol(asciiAnyCharMatcher_1_17);
            csv2ByteBuffer_7.onEol(asciiAnyCharMatcher_1_17);
            csv2ByteBuffer_9.onEol(asciiAnyCharMatcher_1_17);
            csv2ByteBuffer_11.onEol(asciiAnyCharMatcher_1_17);
        }
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.onEol(typedEvent);
        isDirty_trackStreamCsvMarshaller7_15 = trackStreamCsvMarshaller7_15.onEol(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_44(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_asciiAnyCharMatcher_0_16 = asciiAnyCharMatcher_0_16.onChar_44(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16) {
            csv2ByteBuffer_1.onDelimiter(asciiAnyCharMatcher_0_16);
            csv2ByteBuffer_3.onDelimiter(asciiAnyCharMatcher_0_16);
            csv2ByteBuffer_5.onDelimiter(asciiAnyCharMatcher_0_16);
            csv2ByteBuffer_7.onDelimiter(asciiAnyCharMatcher_0_16);
            csv2ByteBuffer_9.onDelimiter(asciiAnyCharMatcher_0_16);
            csv2ByteBuffer_11.onDelimiter(asciiAnyCharMatcher_0_16);
            csv2Double_13.onDelimiter(asciiAnyCharMatcher_0_16);
        }
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_45(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.onSign(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_46(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.onDecimalPoint(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_48(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_0(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_49(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_1(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_50(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_2(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_51(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_3(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_52(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_4(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_53(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_5(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_54(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_6(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_55(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_7(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_56(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_8(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_57(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        isDirty_csv2Double_13 = csv2Double_13.on_9(typedEvent);
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
    }

    private void handle_CharEvent_NoFilter(com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
        //method body - invoke call tree
        isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_1 = csv2ByteBuffer_1.onEvent();
        }
        isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_7 = csv2ByteBuffer_7.onEvent();
        }
        isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_9 = csv2ByteBuffer_9.onEvent();
        }
        isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
        }
        if (isDirty_trackStreamCsvMarshaller7_15) {
            tracks.newTrackStream();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_1.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_3.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_5.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_7.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_9.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_16 | isDirty_asciiAnyCharMatcher_1_17) {
            csv2ByteBuffer_11.onEventComplete();
        }
    }

    @Override
    public void afterEvent() {

        isDirty_asciiAnyCharMatcher_1_17 = false;
        isDirty_csv2ByteBuffer_1 = false;
        isDirty_csv2ByteBuffer_5 = false;
        isDirty_csv2ByteBuffer_9 = false;
        isDirty_csv2Double_13 = false;
        isDirty_asciiAnyCharMatcher_0_16 = false;
        isDirty_csv2ByteBuffer_3 = false;
        isDirty_csv2ByteBuffer_7 = false;
        isDirty_csv2ByteBuffer_11 = false;
        isDirty_trackStreamCsvMarshaller7_15 = false;
    }

    @Override
    public void init() {
        csv2ByteBuffer_1.init();
        csv2ByteBuffer_3.init();
        csv2ByteBuffer_5.init();
        csv2ByteBuffer_7.init();
        csv2ByteBuffer_9.init();
        csv2ByteBuffer_11.init();
        csv2Double_13.init();
        trackStreamCsvMarshaller7_15.init();
    }

    @Override
    public void tearDown() {

    }

    @Override
    public void batchPause() {

    }

    @Override
    public void batchEnd() {

    }

}
