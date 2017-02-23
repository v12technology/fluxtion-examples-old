/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
