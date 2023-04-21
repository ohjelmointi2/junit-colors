package colors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ColorTest {

    private final Color white = new Color(255, 255, 255);
    private final Color black = new Color(0, 0, 0);

    @Test
    public void testCreatingRedColor() {
        Color red = new Color(255, 0, 0);

        assertEquals(255, red.getRed());
        assertEquals(0, red.getGreen());
        assertEquals(0, red.getBlue());
    }

    @Test
    public void testCreatingGreenColor() {
        Color green = new Color(0, 255, 0);

        assertEquals(0, green.getRed());
        assertEquals(255, green.getGreen());
        assertEquals(0, green.getBlue());
    }

    @Test
    public void testCreatingBlueColor() {
        Color blue = new Color(0, 0, 255);

        assertEquals(0, blue.getRed());
        assertEquals(0, blue.getGreen());
        assertEquals(255, blue.getBlue());
    }

    @Test
    public void testDarkeningColor() {
        // arrange
        Color blue = new Color(0, 128, 255);

        // act
        Color darker = blue.darken(0.5);

        // assert
        assertEquals(0, darker.getRed());
        assertEquals(64, darker.getGreen());
        assertEquals(127, darker.getBlue());
    }

    @Test
    public void testLighteningColor() {
        Color blue = new Color(0, 128, 255);

        Color lighter = blue.lighten(0.1);

        assertEquals(25, lighter.getRed());
        assertEquals(140, lighter.getGreen());
        assertEquals(255, lighter.getBlue());
    }

    @Test
    public void testToString() {
        Color blue = new Color(0, 128, 255);

        assertEquals("rgb(0, 128, 255)", blue.toString());
    }

    @Test
    public void testConvertingWhiteToHex() {
        String hex = white.toHex();

        assertEquals("#FFFFFF", hex);
    }

    @Test
    public void testConvertingBlackToHex() {
        String hex = black.toHex();

        assertEquals("#000000", hex);
    }

    @Test
    public void testParsingHexValuesIntoRgb() {
        Color fromHex = Color.parseHex("#0080FF");
        Color fromRgb = new Color(0, 128, 255);

        assertEquals(fromRgb, fromHex);
    }

    @Test()
    public void testColorsCannotBeCreatedWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(-1, -1, -1);
        });
    }

    @Test()
    public void testColorsCannotBeCreatedWithValuesOver255() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(256, 256, 256);
        });
    }
}
