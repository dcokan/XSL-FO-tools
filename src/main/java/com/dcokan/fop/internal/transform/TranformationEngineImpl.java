package com.dcokan.fop.internal.transform;

import java.io.File;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import com.dcokan.fop.transform.TransformationEngine;
import com.dcokan.fop.transform.TransformationInput;

public class TranformationEngineImpl implements TransformationEngine {

  public void transformToPdf(TransformationInput transfInput, OutputStream out) throws FOPException, TransformerException {
    FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
    TransformerFactory factory = TransformerFactory.newInstance();
    FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

    Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

    Transformer transformer = factory.newTransformer(transfInput.getTemplate());

    Result res = new SAXResult(fop.getDefaultHandler());
    transformer.transform(transfInput.getDataInput(), res);
  }

}