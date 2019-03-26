package com.dcokan.fop.transform;

import java.io.OutputStream;

import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;

public interface TransformationEngine {

  void transformToPdf(TransformationInput transfInput, OutputStream out) throws FOPException, TransformerException;
}
