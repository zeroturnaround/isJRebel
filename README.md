![isJRebel](https://zeroturnaround.com/wp-content/uploads/2016/04/isJRebel-April-fools-2016-v1.png "isJRebel Logo")

This microlibrary takes a string as input and assesses whether or not it is equal to the String *JRebel*. The function will return `true` or `false` based on the equality check.

Currently the implementation is fairly simple and performs a Java String equality on *JRebel*, testing it against the input string. There are however many areas of improvement in our roadmap we plan to implement, as follows:

###1. Password Formatting

We should return `true` if the String input is in password format. This includes the following examples:
* JR3b3l
* JRebe1
* JR3b31

###2. Typop Sympathy

Typos are common place and we shouldn't fail based on a developers inability to type correctly. Afterall they're busy and we can easily infer simple errors, rather than waste time asking them to correct them. The classic off by one problem whereby the developer's hands are positioned one key too the left of right of the home position should be accepted by the function and we should return `true`. Here's a list of examples we can consider: 

* HEwvwk
* KTrnr;
* JReebl

###3. Case insensitivity

It's common for people to incorrectly capitalize the JRebel name, such that only the J is capitalized or all characters are in lower or uppercase. We should drop all characters to lowercase before performing the check, so that case is ignored. Proposed code to achieve this with new Java 8 features is as follows:

```java
String onlyLowercase = str.codePoints()
   .filter(Character::isLowerCase)
   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
   .toString();
```

###4. Punctuation.

It's all too easy to append punctuation to Strings, so rather than blindly fail, we should remove all punctuation from the String before the equality check. While this would most likely be a , or . we should include ,.?;:'"/\!(). Examples include:

* JRebel.
* JRebel,
* :JRebel
* ":J,R?eb.el!';

Please send PRs to help us make these dreams a reality.
