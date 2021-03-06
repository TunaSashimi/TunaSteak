# TunaSteak

[![Release Version](https://img.shields.io/github/v/release/TunaSashimi/TunaSteak.svg)](https://github.com/TunaSashimi/TunaSteak/releases)
[![Code Size](https://img.shields.io/github/languages/code-size/TunaSashimi/TunaSteak)](https://github.com/TunaSashimi/TunaSteak)
[![Last Commit](https://img.shields.io/github/last-commit/TunaSashimi/TunaSteak)](https://github.com/TunaSashimi/TunaSteak/commits)
[![license](https://img.shields.io/github/license/TunaSashimi/TunaSteak)](https://github.com/TunaSashimi/TunaSteak/blob/master/LICENSE)

TunaSushi is an MVVM framework based on DataBinding.

## Getting started

Step 1. Add the JitPack repository to your build file

To get a Git project into your build:
Add it in your root build.gradle at the end of repositories:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```  
Step 2. Add the dependency
  
```gradle
  	dependencies {
	        implementation 'com.github.TunaSashimi:TunaSteak:1.0.04'
	}
```
	
## Known Issues

If the attributes defined in the TunaSteak library and the attributes defined in other libraries have the same name and different types, compilation errors will occur.The solution is to define an attribute with the same name in the attr of the main project, but the type contains both.

For example, The content attribute in TView in the TunaSteak library is string, and the content attribute in the constraintlayout library is reference.

When the types of attributes with the same name are inconsistent, you can configure a single content in the project, and the attribute is the union of the two.such as below.

```xml
	<attr name="content" format="reference|string" />
```

## License
TunaSushi is under the MIT license. See the [LICENSE](https://github.com/TunaSashimi/TunaSteak/blob/master/LICENSE) file for details.
