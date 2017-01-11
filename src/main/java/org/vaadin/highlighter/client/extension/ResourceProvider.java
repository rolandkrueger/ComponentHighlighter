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

import com.google.gwt.resources.client.CssResource;

/**
 * <p>
 * Interface that provides the concrete client bundle interface to be used by
 * the {@link ComponentHighlighterConnector}. If nothing different is configured
 * through the widgetset definition (GWT module descriptor), then GWT will
 * create a {@link DefaultResourceProvider} instance in
 * {@link ComponentHighlighterConnector} as {@link ResourceProvider} instance.
 * This default resource provider will ensure that the {@link CssResource}s as
 * defined in highlighter.css are used by default.
 * </p>
 * <p>
 * The purpose of this interface is to make it possible to substitute the CSS
 * definition used for the component highlighter with an own definition. This
 * can be achieved through GWT's deferred binding mechanism. To do so, you have
 * to provide your own implementation of {@link ResourceProvider} that returns
 * your own sub-interface of {@link ComponentHighlighterResources} through
 * {@link #getResources()}. Have a look at {@link DefaultResourceProvider} and
 * {@link DefaultComponentHighlighterResources} to see how your own client
 * bundle has to be designed.
 * </p>
 * <p>
 * After you have written your custom implementation of this interface (name for
 * example <code>MyResourceProvider</code>) and your own subclass of
 * {@link ComponentHighlighterResources}, you can augment your widgetset
 * definition with the following statement for deferred binding which will
 * effectively replace the {@link DefaultResourceProvider} with your own
 * implementation:
 * <pre>
 * &lt;replace-with class="com.example.client.MyResourceProvider"&gt;
 *     &lt;when-type-is class="org.vaadin.highlighter.client.extension.DefaultResourceProvider" /&gt;
 * &lt;/replace-with&gt;
 * </pre>
 *
 * @author Roland Krüger
 * @see DefaultResourceProvider
 * @see DefaultComponentHighlighterResources
 */
public interface ResourceProvider {

    /**
     * Return the client bundle interface to be used for styling the component
     * highlighting labels.
     *
     * @return ComponentHighlighterResources
     */
    ComponentHighlighterResources getResources();
}
