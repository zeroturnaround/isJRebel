/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.zeroturnaround.isjrebel;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public class IsJRebel {

  public static final String JREBEL = "JRebel";

  public static boolean isJRebel(String input) {
    return Stream.of(input)
      .map(IsJRebel::dropPunctuation)
      .map(IsJRebel::l33tReplace)
      .filter(
        s ->
          JREBEL.equalsIgnoreCase(s) || StringUtils.getLevenshteinDistance(JREBEL, s) <= 1
      ).findAny().isPresent();
  }

  private static String l33tReplace(String s) {
    return s.replaceAll("1", "l")
      .replaceAll("3", "e")
      .replaceAll("4", "A")
      .replaceAll("5", "S")
      .replaceAll("6", "b")
      .replaceAll("7", "t")
      .replaceAll("8", "B")
      .replaceAll("9", "g")
      .replaceAll("0", "O");
  }

  private static String dropPunctuation(String input) {
    return input.codePoints()
      .filter(c -> Character.isLetter(c) || Character.isDigit(c) || Character.isWhitespace(c))
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
  }

}
