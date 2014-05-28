/*
 * Copyright 2014 Roland Krüger
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
 */
package org.vaadin.highlighter.client.extension;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Client Bundle interface for the component highlighter. This interface
 * provides the {@link ComponentHighlighterStyle} {@link CssResource} needed for
 * styling the highlighting label.
 * 
 * @author Roland Krüger
 * 
 */
public interface ComponentHighlighterResources extends ClientBundle {
  ComponentHighlighterStyle style();
}
