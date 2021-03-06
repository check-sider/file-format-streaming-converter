# file-format-streaming-converter [![Build Status](https://travis-ci.org/kenshoo/file-format-streaming-converter.svg?branch=master)](https://travis-ci.org/kenshoo/file-format-streaming-converter)

This is a file format converter from xlsx to csv. The main use of this repository is to convert 
large xlsx files to csv files using streams instead of reading the entire contents of a file.
This converter is able to read strings, texts, booleans and dates.


Example:

An xlsx file that looks like this:

|Header 1   | Header 4	|Header 5	|Header 6	  |
|-----------|-----------|-----------|-------------|
|Value 11   | Value 14  |411	    |Value 16	  |
|Value 21   | 411	    |Value 17	|¥a®	      |
|Value 31   | 411	    |Value 18	|ßÐ ÆÄÁ  ®Æ	  |
|Value 51   | 411	    |Value 20	|ウェブの国際化 |
|Value 71   | 411	    |30/07/17	|Æ ç Ü ß à ô  | 
|Value 91   | 411	    |Value 24	|Φ ψ α έ Ω    |
|Value 101  | 411	    |Value 25	|й ф Ы Щ Д	  |


Would translate to a same looking csv file, including the special characters and the dates.

Dependencies
===
This project depends on [excel-streaming-reader](https://github.com/monitorjbl/excel-streaming-reader) which is a library
that provides xlsx file type parsing using streams (for big files). 

Code usage example
=========
Add the jar to your dependenies
**Apache Maven**
```xml
<dependency>
    <groupId>com.kenshoo</groupId>
    <artifactId>xlsx2csv</artifactId>
    <version>0.1.2</version>
</dependency>
```
**Gradle**

`compile 'com.kenshoo:xlsx2csv:0.1.2'`

**Usage**

First you should create an output stream (here I first created a file and an output stream on top).

Then you should create an input stream with the xlsx file that will be translated, for example with ClassLoader method
getSystemResourceAsStream() with the file name a sa parameter. 

Afterwards, you send both the source input stream and the dest output stream to convert:
```java
import com.kenshoo.xlsx2csv.XlsxToCsvConverter;
import java.io.*;

public class Converter {
  private final static String SOURCE_FILE_PATH = "/path/example-input.xslx"
  private final static String DEST_FILE_NAME = "/path/example-result.csv"
    
  //building a new converter with default parameters
  private final XlsxToCsvConverter xlsxToCsvConverter = new XlsxToCsvConverter.Builder().build();
  
    public void function convert() {
      final FileOutputStream outputStream = new FileOutputStream(new File(DEST_FILE_NAME));
      final InputStream inputStream = new FileInputStream((SOURCE_FILE_PATH);
                                                          
      xlsxToCsvConverter.convert(inputStream, outputStream);
    }
}
``` 
After convert(), the translated file should be inside the outputStream (or inside the file).

Acknowledgements
====
[@monitorjbl](https://github.com/monitorjbl) for providing the excel-streaming-reader api.

Licensing
=========
file-format-streaming-converter is licensed under the Apache License, Version 2.0. See
[LICENSE](https://github.com/kenshoo/file-format-streaming-converter/blob/master/LICENSE) for the full
license text.
