package com.java.annotations;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Name;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.SourceVersion;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes({"com.java.annotations.Version"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class VersionProcessor extends AbstractProcessor{
	
	public VersionProcessor() {}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		for (TypeElement currentAnnotation: annotations) {
			Name qualifiedName = currentAnnotation.getQualifiedName();
			
			if(qualifiedName.contentEquals("com.java.annotations.Version")) {
				Set<? extends Element> annotatedElements;
				annotatedElements = roundEnv.getElementsAnnotatedWith(currentAnnotation);
				for (Element element: annotatedElements) {
					Version v = element.getAnnotation(Version.class);
					int major = v.major();
					int minor = v.minor();
					if (major < 0 || minor < 0) {
						// Print the error message
						String errorMsg = "Version cannot" +
											" be negative." +
											" major=" + major +
											" minor=" + minor;
						Messager messager =  this.processingEnv.getMessager();
						messager.printMessage(Kind.ERROR, errorMsg, element);
					}
				}
			}
		}
		return true;
	}

}
