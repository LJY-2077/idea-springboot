package com.cn.dg.common.util;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PinYinHelper {
    public static String PinYinType_QUANPIN = "quanpin";
    public static String PinYinType_SHOUZIMU = "shouzimu";

    public PinYinHelper() {
    }

    private static String getSpellByhanzi(char dghz) {
        Set keySet = HanziMap.spellMap.keySet();
        Iterator it = keySet.iterator();

        String spell;
        String hzzfc;
        do {
            if (!it.hasNext()) {
                return null;
            }

            spell = (String)it.next();
            hzzfc = (String)HanziMap.spellMap.get(spell);
        } while(hzzfc.indexOf(dghz) == -1);

        return spell;
    }

    public static Map<String, String> getHanziPinyinAndShouZiMu(String hanzi) {
        Map<String, String> map = new HashMap();
        char[] chars = hanzi.toCharArray();
        StringBuffer pyqp = new StringBuffer();
        StringBuffer pyszm = new StringBuffer();
        if (hanzi != null && hanzi.trim().length() != 0 && !hanzi.equalsIgnoreCase("null")) {
            int i = 0;

            for(int Len = chars.length; i < Len; ++i) {
                String spell = getSpellByhanzi(chars[i]);
                if (spell == null) {
                    pyqp.append(chars[i]);
                    pyszm.append(chars[i]);
                } else {
                    pyqp.append(spell);
                    pyszm.append(spell.substring(0, 1));
                }
            }

            map.put(PinYinType_QUANPIN, pyqp.toString());
            map.put(PinYinType_SHOUZIMU, pyszm.toString());
            return map;
        } else {
            throw new RuntimeException("\"传入字符串为空，请核实！\"");
        }
    }
}
