package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ResponsiveMode {
	
			static Dimension responsiveScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
			public static double responsiveHeight = responsiveScreenSize.getHeight();
			public static double responsiveWidth = responsiveScreenSize.getWidth();
			
			public static int screenHeight = responsiveScreenSize.height;
			public static int screenWidth = responsiveScreenSize.width;
			
			public static final int RESPONSIVE_BLOCK_SIZE = 10;
			
			public static final double RESPONSIVE_LINE_COUNT = screenHeight / RESPONSIVE_BLOCK_SIZE;
			public static final double RESPONSIVE_COLUMN_COUNT = screenWidth / RESPONSIVE_BLOCK_SIZE;
			
}