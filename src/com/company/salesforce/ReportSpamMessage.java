package com.company.salesforce;

import java.util.HashSet;
import java.util.Set;

public class ReportSpamMessage {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> bannedWordSet = new HashSet<String>();
        for(String str: bannedWords){
            bannedWordSet.add(str);
        }
        int count = 0;
        for(int i = 0; i<message.length; i++){
            if (count == 2){
                return true;
            }
            if (bannedWordSet.contains(message[i])){
                count++;
            }
        }

        return count == 2 ? true : false;
    }
}
