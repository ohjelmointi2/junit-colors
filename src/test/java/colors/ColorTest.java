package colors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ColorTest {

    private final Color white = new Color(255, 255, 255);
    private final Color black = new Color(0, 0, 0);

    @Test
    public void newObjectsCanBeCreatedWithRgbValues() {
        Color red = new Color(255, 2, 1);

        assertEquals(255, red.getRed());
        assertEquals(2, red.getGreen());
        assertEquals(1, red.getBlue());
    }

    @Test
    public void invertChangesLightColorsIntoDarkerOnes() {
        Color light = new Color(5, 10, 15);
        Color dark = new Color(250, 245, 240);

        assertEquals(dark, light.invert());
    }

    @Test
    public void invertChangesDarkColorsIntoLightOnes() {
        Color dark = new Color(254, 253, 252);

        assertEquals(new Color(1, 2, 3), dark.invert());
    }

    @Test
    public void darkeningDecreasesRgbValuesByGivenPercent() {
        Color blue = new Color(0, 128, 255);

        Color darker = blue.darken(0.5);

        assertEquals(0, darker.getRed());
        assertEquals(64, darker.getGreen());
        assertEquals(127, darker.getBlue());
    }

    @Test
    public void ligteningIncreasesBrightnessWithGivenPercentage() {
        Color blue = new Color(0, 128, 255);

        Color lighter = blue.lighten(0.1);

        assertEquals(25, lighter.getRed());
        assertEquals(140, lighter.getGreen());
        assertEquals(255, lighter.getBlue());
    }

    @Test
    public void toStringProducesCssLikeColorString() {
        Color blue = new Color(0, 128, 255);

        assertEquals("rgb(0, 128, 255)", blue.toString());
    }

    @Test
    public void colorCanBeRepresentedWithHexValues() {
        String hex = white.toHex();

        assertEquals("#FFFFFF", hex);
    }

    @Test
    public void hexValuesArePaddedWithRightAmountOfZeros() {
        String hex = black.toHex();

        assertEquals("#000000", hex);
    }

    @Test
    public void hexValuesCanBeParsedIntoRGB() {
        Color fromHex = Color.parseHex("#0080FF");

        Color expected = new Color(0, 128, 255);

        assertEquals(expected, fromHex);
    }

    @Test
    public void colorsCannotBeCreatedWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(-1, -1, -1);
        });
    }

    @Test
    public void testColorsCannotBeCreatedWithValuesOver255() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(256, 256, 256);
        });
    }
}
