package com.projectlibre1.util;

import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * Optional user interface scaling, set with -Dprojectlibre.fontScale=1.5
 * (1.0 = no scaling). It enlarges the Swing look and feel fonts and the
 * hardcoded sizes ProjectLibre uses for rows, bars, headers and its own fonts.
 *
 * Java on Linux/X11 only accepts integer values of sun.java2d.uiScale, so
 * this covers the fractional steps (for example 1.2 or 1.5).
 */
public final class UIScale {
	public static final String PROPERTY = "projectlibre.fontScale";
	private static final float MIN_SCALE = 0.5f;
	private static final float MAX_SCALE = 4.0f;

	private static final float scale = readScale();

	private UIScale() {
	}

	private static float readScale() {
		String value = System.getProperty(PROPERTY);
		if (value == null || value.trim().length() == 0)
			return 1.0f;
		try {
			float f = Float.parseFloat(value.trim().replace(',', '.'));
			if (Float.isNaN(f) || f <= 0)
				return 1.0f;
			return Math.max(MIN_SCALE, Math.min(MAX_SCALE, f));
		} catch (NumberFormatException e) {
			System.err.println("Ignoring invalid " + PROPERTY + "=" + value);
			return 1.0f;
		}
	}

	public static float getScale() {
		return scale;
	}

	public static boolean isScaled() {
		return scale != 1.0f;
	}

	/** Scales a size in pixels, keeping non-positive values (flags such as -1) unchanged. */
	public static int scale(int pixels) {
		if (!isScaled() || pixels <= 0)
			return pixels;
		return Math.max(1, Math.round(pixels * scale));
	}

	/** Inverse of scale(int), for sizes saved to project files. */
	public static int unscale(int pixels) {
		if (!isScaled() || pixels <= 0)
			return pixels;
		return Math.max(1, Math.round(pixels / scale));
	}

	/** Scales a view position saved in a project file (may be null). */
	public static Point scale(Point p) {
		return (p == null || !isScaled()) ? p : new Point(scale(p.x), scale(p.y));
	}

	public static Point unscale(Point p) {
		return (p == null || !isScaled()) ? p : new Point(unscale(p.x), unscale(p.y));
	}

	public static double scale(double pixels) {
		return isScaled() ? pixels * scale : pixels;
	}

	/** Scales a font size in points, rounded to whole points for crisp text. */
	public static int scaleFontSize(int size) {
		if (!isScaled() || size <= 0)
			return size;
		return Math.max(1, Math.round(size * scale));
	}

	public static Font scale(Font font) {
		if (!isScaled() || font == null)
			return font;
		float size = scaleFontSize(Math.round(font.getSize2D()));
		Font scaled = font.deriveFont(size);
		return (font instanceof FontUIResource) ? new FontUIResource(scaled) : scaled;
	}

	/**
	 * Scales every font of the current look and feel. Call right after
	 * UIManager.setLookAndFeel(), before any component is created.
	 */
	public static void scaleLookAndFeelFonts() {
		if (!isScaled())
			return;
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		List<Object> keys = new ArrayList<Object>(defaults.keySet());
		for (Object key : keys) {
			Object value = defaults.get(key); // resolves lazy and active values
			if (value instanceof Font) {
				Font scaled = scale((Font) value);
				defaults.put(key, (scaled instanceof FontUIResource) ? scaled : new FontUIResource(scaled));
			}
		}
	}
}
