package org.alfresco.extension.bulkimport.source.fs;

import org.alfresco.extension.bulkimport.source.BulkImportContentProperty;
import org.alfresco.service.cmr.repository.ContentWriter;

import java.io.File;

public class FilesystemContentProperty implements BulkImportContentProperty {
    private File contentFile;

    public FilesystemContentProperty(final File contentFile) {
        this.contentFile = contentFile;
    }

    @Override
    public String getContentSource() {
        return contentFile.getAbsolutePath();
    }

    @Override
    public long sizeInBytes() {
        return contentFile.length();
    }

    @Override
    public void putContent(ContentWriter writer) {
        writer.guessMimetype(contentFile.getName());
        writer.putContent(contentFile);
        writer.guessEncoding();
    }
}
