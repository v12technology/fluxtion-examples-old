/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example20;

import com.fluxtion.api.annotations.OnBatchEnd;

/**
 *
 * @author greg
 */
public class CharacterClassifier {

    public CharacterMatrixFeature[] charMatchSet;

    public CharacterClassifier(CharacterMatrixFeature[] charMatchSet) {
        this.charMatchSet = charMatchSet;
    }

    public CharacterClassifier() {
    }

    @OnBatchEnd
    public void findBestMatch() {
        CharacterMatrixFeature match = charMatchSet[0];
        if (match.isConfigured()) {
            System.out.println(match);
        }
        for (int i = 1; i < charMatchSet.length; i++) {
            CharacterMatrixFeature testChar = charMatchSet[i];
            if (testChar.isConfigured() & testChar.getSum() > match.getSum()) {
                match = testChar;
            }
            if (testChar.isConfigured()) {
                System.out.println(testChar);
            }
        }
        System.out.println("BEST Matched char:" + match);
    }
}
