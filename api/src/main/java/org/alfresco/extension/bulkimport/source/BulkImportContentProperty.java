/*
 * Copyright (C) 2007 Peter Monks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * This file is part of an unsupported extension to Alfresco.
 * 
 */


package org.alfresco.extension.bulkimport.source;

import org.alfresco.service.cmr.repository.ContentWriter;

/**
 * This interface identifies a property of type cm:content.
 * 
 * @author Andreas Steffan (a.steffan@contentreich.de)
 *
 */
public interface BulkImportContentProperty
{
    /**
     * @return A human-readable reference to the source of the content (used in error messages) <i>(may be null if hasContent() = false)</i>.
     */
    String getContentSource();
    
    /**
     * @return The size (in bytes) of this version, defined as the size of the content (_not_ metadata!) file (will usually be 0 for directories).
     */
    long sizeInBytes();
    
    /**
     * @return True if the content is already in-place (in which case the content url property must be returned from the <code>getMetadata</code> call).
     */
    // boolean contentIsInPlace();
    
    /**
     * Called when the content of this version is ready to be streamed into the repository.
     * 
     * Notes:
     * <ol>
     * <li>This method is not called if contentIsInPlace() returns true.</li>
     * <li>It is the implementer's responsibility to set the MIME type, encoding and/or locale of the content being written.
     * Neither the import tool nor Alfresco will "guess" these values.</li>
     * </ol>
     * 
     * @param writer The ContentWriter to use for this version <i>(will not be null)</i>.
     */
    void putContent(ContentWriter writer);
}