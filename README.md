# TunaSteak

Step 1. Add the JitPack repository to your build file

To get a Git project into your build:
Add it in your root build.gradle at the end of repositories:
		
	allprojects {
		repositories {
		...
		maven { url 'https://jitpack.io' }
	}

Step 2. Add the dependency

  	dependencies {
	        implementation 'com.github.TunaSashimi:TunaSteak:1.0.01'
	}
	
Attention

If there are modules with the same package name, otherwise the generated DataBinderMapperImpl class will be the same. When constructing, only the DataBinderMapperImpl of the upper-level module is retained, and the DataBinderMapperImpl of the dependent module is not added to the mMappers collection of MergedDataBinderMapper. When the DataBinding of the dependent module is obtained Object, because the mMappers collection does not have a corresponding DataBinderMapperImpl class, so 

	ViewDataBinding binding = DataBindingUtil.setContentView(this, layoutId) 
	
always returns null.

If the attributes defined in the TunaSteak library and the attributes defined in other libraries have the same name and different types, compilation errors will occur.The solution is to define an attribute with the same name in the attr of the main project, but the type contains both.

For example, The content attribute in TView in the TunaSteak library is string, and the content attribute in the constraintlayout library is reference.

When the types of attributes with the same name are inconsistent, you can configure a single content in the project, and the attribute is the union of the two.such as below.

	<attr name="content" format="reference|string" />
