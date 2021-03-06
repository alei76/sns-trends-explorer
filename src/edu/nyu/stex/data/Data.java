package edu.nyu.stex.data;

import edu.nyu.stex.data.preprocess.StandardStemming;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Data {
  private String source;
  private String publisher;
  private Date time;
  private String rawContent;
  private String content;
  private HashMap<String, String> properties = new HashMap<String, String>();
  private HashMap<String, ArrayList<String>> listProperties = new HashMap<String, ArrayList<String>>();

  public Data() {
    content = null;
  };

  public String getContent() {
    if (content == null) {
      return rawContentToContent();
    } else {
      return content;
    }
  }

  public HashMap<String, String> getProperties() {
    return properties;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getSource() {
    return source;
  }

  public Date getTime() {
    return time;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public void setProperties(HashMap<String, String> properties) {
    this.properties = properties;
  }

  public HashMap<String, ArrayList<String>> getListProperties() {
    return listProperties;
  }

  public void setListProperties(
      HashMap<String, ArrayList<String>> listProperties) {
    this.listProperties = listProperties;
  }

  public String getRawContent() {
    if (rawContent == null) {

    }
    return rawContent;
  }

  public void setRawContent(String rawContent) {
    this.rawContent = rawContent;
  }

  public String rawContentToContent() {
    List<String> terms = StandardStemming.stemToList(rawContent);
    StringBuilder sb = new StringBuilder();
    for (String term : terms) {
      sb.append(term).append(" ");
    }
    String c = sb.toString();
    content = c;
    return c;
  }
}
