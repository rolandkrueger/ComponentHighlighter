ComponentHighlighter for Vaadin
===============================

ComponentHighlighter is an addon for the Vaadin Toolkit that aims at supporting the Vaadin developer while writing a Vaadin application. The addon provides an extension for components which will highlight an extended component in the browser with a visually striking info label. This feature will only be active when the Vaadin application is running in debug mode.

When building user interfaces with a RIA framework such as Vaadin, your UI is typically composed of single fragments which are implemented by different view classes. In a Vaadin application, a common way to abstract different parts of a user interface is to inherit from class CustomComponent and implement one specific part of the UI in that class. The final UI is then composed of these classes. The more of these classes you maintain in your codebase the harder it is to keep track of all these classes. It may happen more than once that you need to adjust something in some deeply nested part of your UI but while you clearly see the targetted spot in your browser you just have no clue which class implements that particular area of the UI. It would then greatly help if this area of the view was highlighted already in the browser with some eye-catching label that described the name of the implementing class.

This is exactly what the ComponentHighlighter addon is intended to provide.

When you extend an arbitrary Vaadin component (regardless if a component from the framework or your own) a tag will be attached to the component in the browser containing the fully qualified class name of the component. This label can be extended with arbitrary text if you so wish. For example, you could add the name of a CustomLayout's HTML template name. See the screenshot /etc/screenshot.png in this project for an example.

Usage
-----
Using this addon is easy. You only have to include the addon's widget set in your own widget set descriptor:

	<module>
		<inherits name="com.vaadin.DefaultWidgetSet" />
		<inherits name="org.vaadin.highlighter.ComponentHighlighterWidgetset" />
	</module>
	
After that, you have to recompile your widget set. How this is done is extensively described in the Book of Vaadin.

You are now ready to extend your components with the highlighting label. A typical usage pattern for this is the following code

	public class MyComponent extends CustomComponent {
		...
		public MyComponent() {
			super();
			if (!VaadinService.getCurrent().getDeploymentConfiguration().isProductionMode()) {
				new ComponentHighlighterExtension(this);
			}
			...
		}
	}
	
Here you simply create a new extension object for your component if the application is running in debug mode. Querying for the debug mode in that manner will have the effect that in production mode no unnecessary extension objects are created which waste your precious heap memory.

The extension itself guarantees that in production mode an extended component will not be touched in any way on the client side. It is a good thing to do the above check for the debug mode, though, in order to not waste any memory when running in production mode.

Customization
-------------
You don't like pink? Well, if you deem the highlighting labels to be just too visually striking, you can adjust the CSS for them accordingly. The highlighter's CSS is implemented with a GWT ClientBundle. This client bundle is created by a factory class. Using GWT's deferred binding mechanism, you can swap the implementation of this factory in your widget set module descriptor. Your own factory implementation can then provide a different client bundle that provides different styles for the highlighting label.

The following statement has to be added to your widget set definition:

 	<replace-with class="com.example.client.MyResourceProvider">
 		<when-type-is class="org.vaadin.highlighter.client.extension.DefaultResourceProvider" />
 	</replace-with>

Licensing
---------
The addon is licensed under the terms of the Apache License 2.0.