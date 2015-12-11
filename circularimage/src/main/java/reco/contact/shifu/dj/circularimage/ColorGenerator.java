package reco.contact.shifu.dj.circularimage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by deepanshjain on 12/11/15.
 */
public class ColorGenerator {
    public static ColorGenerator DEFAULT;

    public static ColorGenerator MATERIAL;

    static {
        DEFAULT = create(Arrays.asList(0xfff16364, 0xfff58559, 0xfff9a43e, 0xffe4c62e, 0xff67bf74, 0xff59a2be, 0xff2093cd, 0xffad62a7, 0xff805781));
        MATERIAL = create(Arrays.asList(0xfff44336, 0xffe91E63, 0xff9C27B0, 0xff673AB7, 0xff3F51B5, 0xff2196F3, 0xff4fc3f7, 0xff4dd0e1, 0xff4db6ac,
                0xff81c784, 0xffaed581, 0xffff8a65, 0xffd4e157, 0xffffd54f, 0xffffb74d, 0xffa1887f, 0xff90a4ae));
    }

    private final List<Integer> mColors;
    private final Random mRandom;

    public static ColorGenerator create(List<Integer> colorList) {
        return new ColorGenerator(colorList);
    }

    private ColorGenerator(List<Integer> colorList) {
        mColors = colorList;
        mRandom = new Random(System.currentTimeMillis());
    }

    public int getRandomColor() {
        return mColors.get(mRandom.nextInt(mColors.size()));
    }

    public int getColor(Object key) {
        return mColors.get(Math.abs(key.hashCode()) % mColors.size());
    }
}
