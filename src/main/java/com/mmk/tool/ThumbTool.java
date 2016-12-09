package com.mmk.tool;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbTool {
	
	public static File size(File file, int width ,int height ) throws IOException  {
		Path tempFile = Files.createTempFile("thumb", height+"X"+width);
		OutputStream stream = Files.newOutputStream(tempFile);
		Thumbnails.of(file).size(width,height).toOutputStream(stream );
		return tempFile.toFile();
	}
	
}
