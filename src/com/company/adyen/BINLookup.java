package com.company.adyen;

import java.util.*;

public class BINLookup {
    static class BinRange {
        long start;
        long end;
        String cardType;

        BinRange(String startStr, String endStr, String cardType) {
            this.start = parseBin(startStr);
            this.end = parseBin(endStr);
            this.cardType = cardType;
        }

        static long parseBin(String s) {
            return Long.parseLong(s.replaceAll("\\s", ""));
        }
    }

    private final TreeMap<Long, BinRange> binMap;

    public BINLookup(List<String[]> rawRanges) {
        binMap = new TreeMap<>();
        for (String[] entry : rawRanges) {
            BinRange range = new BinRange(entry[0], entry[1], entry[2]);
            binMap.put(range.start, range);
        }
    }

    public String getCardType(String cardNumberStr) {
        long bin = BinRange.parseBin(cardNumberStr.substring(0, 10));
        Map.Entry<Long, BinRange> entry = binMap.floorEntry(bin);
        if (entry != null && bin <= entry.getValue().end) {
            return entry.getValue().cardType;
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        List<String[]> ranges = List.of(
                new String[]{"4444 4444 11", "4444 4444 44", "Visa credit"},
                new String[]{"4500 0000 55", "4999 9999 00", "Visa debit"},
                new String[]{"4999 9999 99", "5555 0000 00", "Master credit"},
                new String[]{"6666 4444 11", "7777 0000 00", "Amex"}
        );

        BINLookup lookup = new BINLookup(ranges);

        String cardNumber = "4733 6109 7901 2139";
        String cardType = lookup.getCardType(cardNumber);
        System.out.println("Card Type: " + cardType);  // Expected: Visa debit
    }
}
