# jing-trang-patch
 patch for:
 http://jing-trang.googlecode.com/svn
 Revision 2368



//preparing the temp logfile
File file = File.createTempFile("transpect-rng-", ".txt");
FileWriter writer = new FileWriter(file);
System.setProperty("LtxValidateTempFile", file.getAbsolutePath());
