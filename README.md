ComponentHighlighter for Vaadin
===============================

ComponentHighlighter is an add-on for the Vaadin Toolkit that aims at supporting the Vaadin developer while writing a Vaadin application. The add-on provides an extension for components which will highlight an extended component in the browser with an eye-catching info label. This feature will only be active when the Vaadin application is running in debug mode.

When building user interfaces with a RIA framework such as Vaadin, your UI is typically composed of single fragments which are implemented by different view classes. In a Vaadin application, a common way to abstract different parts of a user interface is to inherit from class CustomComponent and implement one specific part of the UI in that class. The final UI is then composed of these classes. The more of these classes you maintain in your codebase the harder it is to keep track of all these classes. It may happen more than once that you need to adjust something in some deeply nested part of your UI but while you clearly see the targetted spot in your browser, you just have no clue which class implements that particular area of the UI. It would then greatly help if this area of the view was highlighted already in the browser with some eye-catching label that described the name of the implementing class.

This is exactly what the ComponentHighlighter add-on achieves.

When you extend an arbitrary Vaadin component (whether it be a component from the framework or your own) a tag will be attached to the component in the browser containing the fully qualified class name of the component. This label can be extended with arbitrary text if you so wish. For example, you could add the name of a CustomLayout's HTML template name. See the screenshot /etc/screenshot.png in this project for an example.

Usage
-----
Using this add-on is easy. You only have to include the add-on's widget set in your own widget set descriptor:

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
			new ComponentHighlighterExtension(this);
			...
		}
	}
	
Here, you simply create a new extension object as a local instance in the constructor of a CustomComponent and pass the component to be extended into the extension as a constructor argument, which in this case is the this reference. 

The extension itself guarantees that in production mode an extended component will not be touched in any way on the client side. If your application is running in production mode, the ComponentHighlighterExtension will do nothing when calling its extend() method. It will then just silently return from the extend() method without actually extending the given component. By that, you won't waste any memory for the extension objects when running in production mode. If you create ComponentHighlighterExtension instances as local instances as shown above, the garbage collector will then reclaim the memory of these references right away.

Customization
-------------
You don't like pink? Well, if you deem the highlighting labels to be just too striking, you can adjust the CSS used for them accordingly. The add-on's CSS is implemented through a GWT ClientBundle. This client bundle is created by a factory (interface ResourceProvider). Using GWT's deferred binding mechanism, you can substitute the implementation of this factory in your widgetset module descriptor with your own factory implementation. This custom implementation can then create a different client bundle that provides different styles for the highlighting label.

To do that, you have to write your own implementation of ResourceProvider (e.g. MyResourceProvider) and your own sub-interface of ComponentHighlighterResources as described in the accompanying JavaDocs.

You then need to add the following statement to your widgetset definition:

 	<replace-with class="com.example.client.MyResourceProvider">
 		<when-type-is class="org.vaadin.highlighter.client.extension.DefaultResourceProvider" />
 	</replace-with>
	
Blog Post
----------------------
A blog post has been published that describes the add-on in more detail. You'll find that post at [http://blog.oio.de](http://blog.oio.de).

Licensing
---------
The add-on is licensed under the terms of the Apache License 2.0.