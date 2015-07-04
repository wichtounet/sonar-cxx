/*
 * Sonar C++ Plugin (Community)
 * Copyright (C) 2011 Waleri Enns and CONTACT Software GmbH
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.cxx.checks;

import org.sonar.squidbridge.checks.CheckMessagesVerifier;
import org.junit.Test;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.cxx.CxxAstScanner;

import java.io.File;

public class ClassComplexityCheckTest {

  @Test
  public void test() {
    ClassComplexityCheck check = new ClassComplexityCheck();
    check.setMaximumClassComplexityThreshold(5);

    SourceFile file = CxxAstScanner.scanSingleFile(new File("src/test/resources/checks/ClassComplexity.cc"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages())
      .next().atLine(9).withMessage("Class has a complexity of 9 which is greater than 5 authorized.")
      .noMore();
  }

}