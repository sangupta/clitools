clitools
========

A bundle of command-line tools that are quite useful in day-to-day life. Some of these tools
are available directly on some OS platforms - but not all - and hence, the cross-platform
implementation.

Changelog
---------

**Current Development**

```
  base64     Base64 encode/decode                                   
  crc32      Compute the CRC32 hash of given file/file pattern(s)   
  curr       Currency converter                                     
  epoch      Show current time as epoch, millis in GMT              
  fbinfo     Show information about a facebook account or page      
  filesort   Tool to sort files in a directory by prefixing numerals
  findfile   Find files in a directory                              
  gd         Google dictionary from command line                    
  hex        Dump a given file as hex                               
  htalk      Search hackernews threads                              
  imdb       Fetch movie information from IMDB                      
  ltrim      Remove whitespaces from start of each line of the file 
  md2        Compute the MD2 hash of given file/file pattern(s)     
  md5        Compute the MD5 hash of given file/file pattern(s)     
  mvnsearch  Search Maven artifacts                                 
  myip       Display the IP address of this machine                 
  prop       Provides access to user properties                     
  randfile   Generate a random file of given size                   
  rtrim      Remove whitespaces from end of each line of the file   
  sha1       Compute the SHA1 hash of given file/file pattern(s)    
  sha256     Compute the SHA256 hash of given file/file pattern(s)  
  sha384     Compute the SHA384 hash of given file/file pattern(s)  
  sha512     Compute the SHA512 hash of given file/file pattern(s)  
  stock      Stock quotes from NASDAQ                               
  trim       Remove whitespaces from each line of the file          
  uuidgen    Generates a new universally unique identifier (UUID)   
```

Versioning
----------

For transparency and insight into our release cycle, and for striving to maintain backward compatibility, 
`htalk` will be maintained under the Semantic Versioning guidelines as much as possible.

Releases will be numbered with the follow format:

`<major>.<minor>.<patch>`

And constructed with the following guidelines:

* Breaking backward compatibility bumps the major
* New additions without breaking backward compatibility bumps the minor
* Bug fixes and misc changes bump the patch

For more information on SemVer, please visit http://semver.org/.

License
-------
	
```
clitools - Simple command line tools
Copyright (c) 2014 - 2015, Sandeep Gupta

	http://sangupta.com/projects/clitools

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
