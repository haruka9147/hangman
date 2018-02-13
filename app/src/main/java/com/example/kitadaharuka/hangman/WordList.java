package com.example.kitadaharuka.hangman;

import java.util.ArrayList;

/**
 * Created by kitadaharuka on 2018/02/13.
 */

public class WordList {
    private ArrayList<Word> words;

    public WordList() {
        this.words = new ArrayList<>();
        words.add(new Word("ACCOUNT"));
        words.add(new Word("APPLE"));
        words.add(new Word("ABILITY"));
        words.add(new Word("ABSENCE"));
        words.add(new Word("ACCIDENT"));

        words.add(new Word("BABY"));
        words.add(new Word("BAGGAGE"));
        words.add(new Word("BUS"));
        words.add(new Word("BICYCLE"));
        words.add(new Word("BRAZIL"));

        words.add(new Word("CAKE"));
        words.add(new Word("COMPANY"));
        words.add(new Word("CHEF"));
        words.add(new Word("CACTUS"));
        words.add(new Word("CHINA"));

        words.add(new Word("DUMPLING"));
        words.add(new Word("DAMAGE"));
        words.add(new Word("DANDELION"));
        words.add(new Word("DAUGHTER"));
        words.add(new Word("DOMINICA"));

        words.add(new Word("EDITION"));
        words.add(new Word("EASE"));
        words.add(new Word("EARTH"));
        words.add(new Word("EAST"));
        words.add(new Word("EASYGOING"));

        words.add(new Word("FROZEN"));
        words.add(new Word("FORTUNE"));
        words.add(new Word("FAMILY"));
        words.add(new Word("FAIR"));
        words.add(new Word("FACTORY"));

        words.add(new Word("GARBAGE"));
        words.add(new Word("GENERATION"));
        words.add(new Word("GENTLEMAN"));
        words.add(new Word("GAME"));
        words.add(new Word("GEOGRAPHY"));

        words.add(new Word("HARDWARE"));
        words.add(new Word("HABIT"));
        words.add(new Word("HANDSOME"));
        words.add(new Word("HIKING"));
        words.add(new Word("HARVEST"));

        words.add(new Word("INTERIOR"));
        words.add(new Word("IMAGINATION"));
        words.add(new Word("IGNORE"));
        words.add(new Word("IDENTITY"));
        words.add(new Word("IDEAL"));

        words.add(new Word("JACKET"));
        words.add(new Word("JUDGEMENT"));
        words.add(new Word("JEALOUSY"));
        words.add(new Word("JAPAN"));
        words.add(new Word("JELLYFISH"));

        words.add(new Word("KOALA"));
        words.add(new Word("KUMQUAT"));
        words.add(new Word("KNOWLEDGE"));
        words.add(new Word("KINGDOM"));
        words.add(new Word("KARAOKE"));

        words.add(new Word("LABOR"));
        words.add(new Word("LANDLORD"));
        words.add(new Word("LATEST"));
        words.add(new Word("LAG"));
        words.add(new Word("LABORATORY"));

        words.add(new Word("MANATEE"));
        words.add(new Word("MERMAID"));
        words.add(new Word("MEXICO"));
        words.add(new Word("MOTH"));
        words.add(new Word("MAPLE"));

        words.add(new Word("NEIGHBOR"));
        words.add(new Word("NERVOUS"));
        words.add(new Word("NEUTRAL"));
        words.add(new Word("NAP"));
        words.add(new Word("NAVY"));

        words.add(new Word("OYSTER"));
        words.add(new Word("OCTOPUS"));
        words.add(new Word("OAK"));
        words.add(new Word("OBLIGATION"));
        words.add(new Word("OUTCOME"));

        words.add(new Word("PIZZA"));
        words.add(new Word("PHOTOGRAPHER"));
        words.add(new Word("PARTY"));
        words.add(new Word("PERU"));
        words.add(new Word("PIGEON"));

        words.add(new Word("QUOTA"));
        words.add(new Word("QUALITY"));
        words.add(new Word("QUEST"));
        words.add(new Word("QUESTION"));
        words.add(new Word("QUIET"));

        words.add(new Word("REINDEER"));
        words.add(new Word("RADISH"));
        words.add(new Word("ROSE"));
        words.add(new Word("RAY"));
        words.add(new Word("ROUTINE"));

        words.add(new Word("STORK"));
        words.add(new Word("SWALLOW"));
        words.add(new Word("SQUASH"));
        words.add(new Word("SOYBEAN"));
        words.add(new Word("SPINACH"));

        words.add(new Word("TURKEY"));
        words.add(new Word("TAIWAN"));
        words.add(new Word("THAILAND"));
        words.add(new Word("TIGER"));
        words.add(new Word("TUNA"));

        words.add(new Word("UNCLE"));
        words.add(new Word("UNKNOWN"));
        words.add(new Word("URGENCY"));
        words.add(new Word("UNIFORM"));
        words.add(new Word("UNIVERSE"));

        words.add(new Word("VALLY"));
        words.add(new Word("VEGETABLE"));
        words.add(new Word("VENTURE"));
        words.add(new Word("VICTOR"));
        words.add(new Word("VIRUS"));

        words.add(new Word("WHALE"));
        words.add(new Word("WOLF"));
        words.add(new Word("WINE"));
        words.add(new Word("WATER"));
        words.add(new Word("WALRUS"));

        words.add(new Word("XYLOPHONE"));
        words.add(new Word("XYLITOL"));
        words.add(new Word("XANADU"));
        words.add(new Word("XENON"));
        words.add(new Word("XENOPHOBE"));

        words.add(new Word("YOLK"));
        words.add(new Word("YARD"));
        words.add(new Word("YOUTH"));
        words.add(new Word("YELLOW"));
        words.add(new Word("YEARN"));

        words.add(new Word("ZEBRA"));
        words.add(new Word("ZEALOT"));
        words.add(new Word("ZONE"));
        words.add(new Word("ZODIAC"));
        words.add(new Word("ZEST"));
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }
}
