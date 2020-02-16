package com.github.oxo42.stateless4j;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qintang
 */
public abstract class X11ColorScheme {

    /** https://graphviz.gitlab.io/_pages/doc/info/colors.html */
    private static final String LOVE_COLOR_SCHEME_="antiquewhite4\taquamarine4\taquamarine4\tblue\tblack\tblueviolet\tchocolate1\t"
            +"cyan\tbrown1\tchartreuse\tdeeppink\tgold3\tdarkgreen";

    private static final String COLOR_SCHEME_="aliceblue\tantiquewhite\tantiquewhite1\tantiquewhite2\tantiquewhite3\n" +
            "antiquewhite4\taquamarine\taquamarine1\taquamarine2\taquamarine3\n" +
            "aquamarine4\tazure\tazure1\tazure2\tazure3\n" +
            "azure4\tbeige\tbisque\tbisque1\tbisque2\n" +
            "bisque3\tbisque4\tblack\tblanchedalmond\t   blue   \n" +
            "blue1\tblue2\tblue3\tblue4\tblueviolet\n" +
            "brown\tbrown1\tbrown2\tbrown3\tbrown4\n" +
            "burlywood\tburlywood1\tburlywood2\tburlywood3\tburlywood4\n" +
            "cadetblue\tcadetblue1\tcadetblue2\tcadetblue3\tcadetblue4\n" +
            "chartreuse\tchartreuse1\tchartreuse2\tchartreuse3\tchartreuse4\n" +
            "chocolate\tchocolate1\tchocolate2\tchocolate3\tchocolate4\n" +
            "coral\tcoral1\tcoral2\tcoral3\tcoral4\n" +
            "cornflowerblue\tcornsilk\tcornsilk1\tcornsilk2\tcornsilk3\n" +
            "cornsilk4\tcrimson\t   cyan   \tcyan1\tcyan2\n" +
            "cyan3\tcyan4\tdarkgoldenrod\tdarkgoldenrod1\tdarkgoldenrod2\n" +
            "darkgoldenrod3\tdarkgoldenrod4\tdarkgreen\tdarkkhaki\tdarkolivegreen\n" +
            "darkolivegreen1\tdarkolivegreen2\tdarkolivegreen3\tdarkolivegreen4\tdarkorange\n" +
            "darkorange1\tdarkorange2\tdarkorange3\tdarkorange4\tdarkorchid\n" +
            "darkorchid1\tdarkorchid2\tdarkorchid3\tdarkorchid4\tdarksalmon\n" +
            "darkseagreen\tdarkseagreen1\tdarkseagreen2\tdarkseagreen3\tdarkseagreen4\n" +
            "darkslateblue\tdarkslategray\tdarkslategray1\tdarkslategray2\tdarkslategray3\n" +
            "darkslategray4\tdarkslategrey\tdarkturquoise\tdarkviolet\tdeeppink\n" +
            "deeppink1\tdeeppink2\tdeeppink3\tdeeppink4\tdeepskyblue\n" +
            "deepskyblue1\tdeepskyblue2\tdeepskyblue3\tdeepskyblue4\tdimgray\n" +
            "dimgrey\tdodgerblue\tdodgerblue1\tdodgerblue2\tdodgerblue3\n" +
            "dodgerblue4\tfirebrick\tfirebrick1\tfirebrick2\tfirebrick3\n" +
            "firebrick4\tfloralwhite\tforestgreen\tgainsboro\tghostwhite\n" +
            "   gold   \tgold1\tgold2\tgold3\tgold4\n" +
            "goldenrod\tgoldenrod1\tgoldenrod2\tgoldenrod3\tgoldenrod4\n" +
            "   gray   \tgray0\tgray1\tgray10\tgray100\n" +
            "gray11\tgray12\tgray13\tgray14\tgray15\n" +
            "gray16\tgray17\tgray18\tgray19\tgray2\n" +
            "gray20\tgray21\tgray22\tgray23\tgray24\n" +
            "gray25\tgray26\tgray27\tgray28\tgray29\n" +
            "gray3\tgray30\tgray31\tgray32\tgray33\n" +
            "gray34\tgray35\tgray36\tgray37\tgray38\n" +
            "gray39\tgray4\tgray40\tgray41\tgray42\n" +
            "gray43\tgray44\tgray45\tgray46\tgray47\n" +
            "gray48\tgray49\tgray5\tgray50\tgray51\n" +
            "gray52\tgray53\tgray54\tgray55\tgray56\n" +
            "gray57\tgray58\tgray59\tgray6\tgray60\n" +
            "gray61\tgray62\tgray63\tgray64\tgray65\n" +
            "gray66\tgray67\tgray68\tgray69\tgray7\n" +
            "gray70\tgray71\tgray72\tgray73\tgray74\n" +
            "gray75\tgray76\tgray77\tgray78\tgray79\n" +
            "gray8\tgray80\tgray81\tgray82\tgray83\n" +
            "gray84\tgray85\tgray86\tgray87\tgray88\n" +
            "gray89\tgray9\tgray90\tgray91\tgray92\n" +
            "gray93\tgray94\tgray95\tgray96\tgray97\n" +
            "gray98\tgray99\tgreen\tgreen1\tgreen2\n" +
            "green3\tgreen4\tgreenyellow\t   grey   \tgrey0\n" +
            "grey1\tgrey10\tgrey100\tgrey11\tgrey12\n" +
            "grey13\tgrey14\tgrey15\tgrey16\tgrey17\n" +
            "grey18\tgrey19\tgrey2\tgrey20\tgrey21\n" +
            "grey22\tgrey23\tgrey24\tgrey25\tgrey26\n" +
            "grey27\tgrey28\tgrey29\tgrey3\tgrey30\n" +
            "grey31\tgrey32\tgrey33\tgrey34\tgrey35\n" +
            "grey36\tgrey37\tgrey38\tgrey39\tgrey4\n" +
            "grey40\tgrey41\tgrey42\tgrey43\tgrey44\n" +
            "grey45\tgrey46\tgrey47\tgrey48\tgrey49\n" +
            "grey5\tgrey50\tgrey51\tgrey52\tgrey53\n" +
            "grey54\tgrey55\tgrey56\tgrey57\tgrey58\n" +
            "grey59\tgrey6\tgrey60\tgrey61\tgrey62\n" +
            "grey63\tgrey64\tgrey65\tgrey66\tgrey67\n" +
            "grey68\tgrey69\tgrey7\tgrey70\tgrey71\n" +
            "grey72\tgrey73\tgrey74\tgrey75\tgrey76\n" +
            "grey77\tgrey78\tgrey79\tgrey8\tgrey80\n" +
            "grey81\tgrey82\tgrey83\tgrey84\tgrey85\n" +
            "grey86\tgrey87\tgrey88\tgrey89\tgrey9\n" +
            "grey90\tgrey91\tgrey92\tgrey93\tgrey94\n" +
            "grey95\tgrey96\tgrey97\tgrey98\tgrey99\n" +
            "honeydew\thoneydew1\thoneydew2\thoneydew3\thoneydew4\n" +
            "hotpink\thotpink1\thotpink2\thotpink3\thotpink4\n" +
            "indianred\tindianred1\tindianred2\tindianred3\tindianred4\n" +
            "indigo\tinvis\tivory\tivory1\tivory2\n" +
            "ivory3\tivory4\tkhaki\tkhaki1\tkhaki2\n" +
            "khaki3\tkhaki4\tlavender\tlavenderblush\tlavenderblush1\n" +
            "lavenderblush2\tlavenderblush3\tlavenderblush4\tlawngreen\tlemonchiffon\n" +
            "lemonchiffon1\tlemonchiffon2\tlemonchiffon3\tlemonchiffon4\tlightblue\n" +
            "lightblue1\tlightblue2\tlightblue3\tlightblue4\tlightcoral\n" +
            "lightcyan\tlightcyan1\tlightcyan2\tlightcyan3\tlightcyan4\n" +
            "lightgoldenrod\tlightgoldenrod1\tlightgoldenrod2\tlightgoldenrod3\tlightgoldenrod4\n" +
            "lightgoldenrodyellow\tlightgray\tlightgrey\tlightpink\tlightpink1\n" +
            "lightpink2\tlightpink3\tlightpink4\tlightsalmon\tlightsalmon1\n" +
            "lightsalmon2\tlightsalmon3\tlightsalmon4\tlightseagreen\tlightskyblue\n" +
            "lightskyblue1\tlightskyblue2\tlightskyblue3\tlightskyblue4\tlightslateblue\n" +
            "lightslategray\tlightslategrey\tlightsteelblue\tlightsteelblue1\tlightsteelblue2\n" +
            "lightsteelblue3\tlightsteelblue4\tlightyellow\tlightyellow1\tlightyellow2\n" +
            "lightyellow3\tlightyellow4\tlimegreen\tlinen\tmagenta\n" +
            "magenta1\tmagenta2\tmagenta3\tmagenta4\tmaroon\n" +
            "maroon1\tmaroon2\tmaroon3\tmaroon4\tmediumaquamarine\n" +
            "mediumblue\tmediumorchid\tmediumorchid1\tmediumorchid2\tmediumorchid3\n" +
            "mediumorchid4\tmediumpurple\tmediumpurple1\tmediumpurple2\tmediumpurple3\n" +
            "mediumpurple4\tmediumseagreen\tmediumslateblue\tmediumspringgreen\tmediumturquoise\n" +
            "mediumvioletred\tmidnightblue\tmintcream\tmistyrose\tmistyrose1\n" +
            "mistyrose2\tmistyrose3\tmistyrose4\tmoccasin\tnavajowhite\n" +
            "navajowhite1\tnavajowhite2\tnavajowhite3\tnavajowhite4\t   navy   \n" +
            "navyblue\t   none   \toldlace\tolivedrab\tolivedrab1\n" +
            "olivedrab2\tolivedrab3\tolivedrab4\torange\torange1\n" +
            "orange2\torange3\torange4\torangered\torangered1\n" +
            "orangered2\torangered3\torangered4\torchid\torchid1\n" +
            "orchid2\torchid3\torchid4\tpalegoldenrod\tpalegreen\n" +
            "palegreen1\tpalegreen2\tpalegreen3\tpalegreen4\tpaleturquoise\n" +
            "paleturquoise1\tpaleturquoise2\tpaleturquoise3\tpaleturquoise4\tpalevioletred\n" +
            "palevioletred1\tpalevioletred2\tpalevioletred3\tpalevioletred4\tpapayawhip\n" +
            "peachpuff\tpeachpuff1\tpeachpuff2\tpeachpuff3\tpeachpuff4\n" +
            "   peru   \t   pink   \tpink1\tpink2\tpink3\n" +
            "pink4\t   plum   \tplum1\tplum2\tplum3\n" +
            "plum4\tpowderblue\tpurple\tpurple1\tpurple2\n" +
            "purple3\tpurple4\t   red   \t   red1   \t   red2   \n" +
            "   red3   \t   red4   \trosybrown\trosybrown1\trosybrown2\n" +
            "rosybrown3\trosybrown4\troyalblue\troyalblue1\troyalblue2\n" +
            "royalblue3\troyalblue4\tsaddlebrown\tsalmon\tsalmon1\n" +
            "salmon2\tsalmon3\tsalmon4\tsandybrown\tseagreen\n" +
            "seagreen1\tseagreen2\tseagreen3\tseagreen4\tseashell\n" +
            "seashell1\tseashell2\tseashell3\tseashell4\tsienna\n" +
            "sienna1\tsienna2\tsienna3\tsienna4\tskyblue\n" +
            "skyblue1\tskyblue2\tskyblue3\tskyblue4\tslateblue\n" +
            "slateblue1\tslateblue2\tslateblue3\tslateblue4\tslategray\n" +
            "slategray1\tslategray2\tslategray3\tslategray4\tslategrey\n" +
            "   snow   \tsnow1\tsnow2\tsnow3\tsnow4\n" +
            "springgreen\tspringgreen1\tspringgreen2\tspringgreen3\tspringgreen4\n" +
            "steelblue\tsteelblue1\tsteelblue2\tsteelblue3\tsteelblue4\n" +
            "   tan   \t   tan1   \t   tan2   \t   tan3   \t   tan4   \n" +
            "thistle\tthistle1\tthistle2\tthistle3\tthistle4\n" +
            "tomato\ttomato1\ttomato2\ttomato3\ttomato4\n" +
            "transparent\tturquoise\tturquoise1\tturquoise2\tturquoise3\n" +
            "turquoise4\tviolet\tvioletred\tvioletred1\tvioletred2\n" +
            "violetred3\tvioletred4\twheat\twheat1\twheat2\n" +
            "wheat3\twheat4\twhite\twhitesmoke\tyellow\n" +
            "yellow1\tyellow2\tyellow3\tyellow4\tyellowgreen";

    private static final String[] COLOR_SCHEME=COLOR_SCHEME_.split("\t|\n");
    private static final String[] LOVE_COLOR_SCHEME=LOVE_COLOR_SCHEME_.split("\t|\n");
    private static String[] COLOR_SCHEME_MY;
    static {
        //去掉颜色后的数字，排重
        Set<String> colerSet=new HashSet();
        String pattern = "\\d+(\\w+)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        for (String color:COLOR_SCHEME) {
            String color_=new StringBuilder(color.trim()).reverse().toString();
            Matcher m = r.matcher(color_);
            if (m.find( )) {
                String color__= new StringBuilder(m.group(1)).reverse().toString();
                colerSet.add(color__);
            }else {
                colerSet.add(color.trim());
            }

        }
        COLOR_SCHEME_MY= colerSet.toArray(new String[]{});
    }

    public static String randomAllColor(){
        //(数据类型)(最小值+Math.random()*(最大值-最小值+1))
        int index=(int)(0+Math.random()*((COLOR_SCHEME_MY.length-1)-1+1));
        return COLOR_SCHEME_MY[index];
    }

    public static String randomColor(){
        //(数据类型)(最小值+Math.random()*(最大值-最小值+1))
        int index=(int)(0+Math.random()*((LOVE_COLOR_SCHEME.length-1)-1+1));
        return LOVE_COLOR_SCHEME[index];
    }
}
