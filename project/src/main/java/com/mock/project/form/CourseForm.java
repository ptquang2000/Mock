package com.mock.project.form;

public class CourseForm {
  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;

  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      "}";
  }

}
