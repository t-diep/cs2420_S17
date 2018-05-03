README

1) AUTHOR INFORMATION
Homework 12 - Huffman Encoding
My Name: Tony Diep
Partner: Alex Cervantes
Date:    April 25, 2017

2) SUMMARY
	This assignment encompassed on the idea of Huffman encoding, which is
basically the idea of loseless compression by representing fewer bytes
while maintain the original data initially.  Huffman encoding takes all of the
most frequent symbols in a text file and places them on higher rows of the 
Huffman tree while placing infrequent symbols on the bottom rows of the 
Huffman tree. 
	
3) LATE WORK
	We wanted to turn in the assignment on Friday, April 21, but we still
had to work on the Huffman Tree class.  Because of this, we decided to 
turn in the assignment on Tuesday, April 25, which was the cutoff date
to turn in the assignment without penalty.  

4) NOTES TO THE TA
	Our timing experiment involves constructing many compressed and decompressed
files since we are testing many different counts of the top frequent words in 
a text file with the amount of time it takes to compress and decompress.  
The way the experiment is setup is basically for each different word count
and for each different text file, a Huffman Tree object is created.  
	Thus, it is important to warn that when running the timing experiment,
there will be a bunch of these compressed and decompressed files

	We also created a "toy" class to help us understand how bit and byte
shifting work.  Although we realized we could just abstract this idea,
it never hurts to take an extra step to understand the bit and byte
system. This "toy" class is called BitBytePlayground.

5) PLEDGE

	I pledge that the work done here was my own and that I have learned how to write
 this program (such that I could throw it out and restart and finish it in a timely
 manner).  I am not turning in any work that I cannot understand, describe, or
 recreate.  Any sources (e.g., web sites) other than the lecture that I used to
 help write the code are cited in my work.  When working with a partner, I have
 contributed an equal share and understand all the submitted work.  Further, I have
 helped write all the code assigned as pair-programming and reviewed all code that
 was written separately.
	(Tony Diep)
	
6) DESIGN DECISIONS
-Start working on JUnit Tests first, then complete the implementation.  Then complete
the Node class since Utility and Bit_Operation classes were already done.  Finally,
tackle the HuffmanTree class while also following the roadmap along the way.	 

7) PROBLEMS ENCOUNTERED AND THEIR SOLUTIONS
~Our decompression did not work for bigger files such as "green_eggs_and_ham", "decl_of_ind",
and "two_cities".  We spent over 2 hours debugging and configuring the problem, but when going
to Jim's office hours, it was because of not using abstraction.  We created our own method
to do bit shifting that takes in 4 bytes.  
