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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;

/**
 * <p>
 * Default sub-interface of {@link ComponentHighlighterResources} which will be
 * used unless otherwise configured in the widgetset descriptor. This default
 * interface will link the included highlighter.css file with the
 * {@link CssResource} provided by this client bundle.
 * </p>
 * <p>
 * If you want to define your own CSS styles for the component highlighter, you
 * need to write an own sub-interface of {@link ComponentHighlighterResources}
 * that refers to your own css-file in the same way as is done by this
 * interface. This custom interface has then to be provided by your own
 * implementation of {@link ResourceProvider}.
 * </p>
 * 
 * @author Roland Krüger
 * @see ResourceProvider for more information on configuratively swapping the
 *      {@link CssResource} used by this extension
 */
public interface DefaultComponentHighlighterResources extends ComponentHighlighterResources {

  public static final DefaultComponentHighlighterResources HIGHLIGHTER_RESOURCE = GWT
      .create(DefaultComponentHighlighterResources.class);

  @Source("highlighter.css")
  ComponentHighlighterStyle style();
}
