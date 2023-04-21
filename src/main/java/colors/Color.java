package colors;

/**
 * "The RGB color model is an additive color model in which the red, green and
 * blue primary colors of light are added together in various ways to reproduce
 * a broad array of colors. The name of the model comes from the initials of the
 * three additive primary colors, red, green, and blue."
 * 
 * https://en.wikipedia.org/wiki/RGB_color_model
 */
public final class Color {
    private final int red;
    private final int green;
    private final int blue;

    /**
     * "8 bits in three color channels with values of 0–255"
     * 
     * https://en.wikipedia.org/wiki/RGB_color_model
     */
    public Color(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException("RGB values between 0-255 allowed");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    /**
     * Returns a new Color that is darkened by the given percentage.
     * 
     * @param percentage 0.0 - 1.0
     * @return Darker color
     */
    public Color darken(double percentage) {
        int newRed = (int) (red * (1 - percentage));
        int newGreen = (int) (green * (1 - percentage));
        int newBlue = (int) (blue * (1 - percentage));
        return new Color(newRed, newGreen, newBlue);
    }

    /**
     * Returns a new Color that is lightened by the given percentage.
     * 
     * @param percentage 0.0 - 1.0
     * @return Lighter color
     */
    public Color lighten(double percentage) {
        int newRed = (int) (red + (255 - red) * percentage);
        int newGreen = (int) (green + (255 - green) * percentage);
        int newBlue = (int) (blue + (255 - blue) * percentage);

        return new Color(newRed, newGreen, newBlue);
    }

    @Override
    public String toString() {
        return "rgb(%d, %d, %d)".formatted(this.red, this.green, this.blue);
    }

    public String toHex() {
        return "#%02X%02X%02X".formatted(this.red, this.green, this.blue);
    }

    public static Color parseHex(String hex) {
        int r = Integer.parseInt(hex.substring(1, 3), 16);
        int g = Integer.parseInt(hex.substring(3, 5), 16);
        int b = Integer.parseInt(hex.substring(5, 7), 16);
        return new Color(r, g, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Color) {
            Color other = (Color) obj;
            return this.red == other.red && this.green == other.green && this.blue == other.blue;
        }
        return false;
    }
}