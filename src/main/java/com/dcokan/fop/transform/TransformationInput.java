package com.dcokan.fop.transform;

import javax.xml.transform.Source;

public interface TransformationInput {

  Source getTemplate();

  Source getDataInput();
}
