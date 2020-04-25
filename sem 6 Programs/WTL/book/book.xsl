<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="BOOKS">
<html>
<head>
<title>XSLT</title>
<link rel="stylesheet" type="text/css" href="book.css"/>
<style>
table,tr,th,td{border:2px solid black;border-collapse:collapse; font-size:20px}
</style>
</head>
<body bgcolor="#8080ff">
<h2 align="center"><u>BOOKS</u></h2>

<table border="2" height="400px" align="center">
<tr>
<th style="background-color:grey;color:white;height:40px;width:240px">TITLE</th>
<th style="background-color:grey;color:white;width:170px;">AUTHOR</th>
<th style="background-color:grey;color:white;width:90px;">PRICE</th>
</tr>
<xsl:for-each select="BOOK">
<xsl:sort select="PRICE"/>
<tr>
<td><xsl:value-of select="TITLE"/></td>
<td><xsl:value-of select="AUTHOR"/></td>
<td align="center"><xsl:value-of select="PRICE"/></td>
</tr>
</xsl:for-each>
</table>

<br></br>

<table border="2" align="center">
<tr>
<th style="background-color:green;height:40px;width:240px;color:white">TITLE</th>
<th style="background-color:green;width:170px;color:white">AUTHOR</th>
<th style="background-color:green;width:90px;color:white">PRICE</th>
</tr>
<xsl:for-each select="BOOK">
<xsl:if test="PRICE &gt; 250">
<tr>
<td><xsl:value-of select="TITLE"/></td>
<td><xsl:value-of select="AUTHOR"/></td>
<td align="center"><xsl:value-of select="PRICE"/></td>
</tr>
</xsl:if>
</xsl:for-each>
</table>

<br></br>

<table border="2" height="400px" align="center">
<tr>
<th style="background-color:brown;height:40px;width:240px;color:white">TITLE</th>
<th style="background-color:brown;width:170px;color:white">AUTHOR</th>
<th style="background-color:brown;width:90px;color:white">PRICE</th>
</tr>
<xsl:for-each select="BOOK">
<tr>
<xsl:choose>
<xsl:when test="PRICE &gt; 400">
<td style="background-color:pink;color:red"><xsl:value-of select="TITLE"/></td>
<td style="background-color:pink;color:red"><xsl:value-of select="AUTHOR"/></td>
<td style="background-color:pink;color:red" align="center"><xsl:value-of select="PRICE"/></td>
</xsl:when>
<xsl:otherwise>
<td><xsl:value-of select="TITLE"/></td>
<td><xsl:value-of select="AUTHOR"/></td>
<td align="center"><xsl:value-of select="PRICE"/></td>
</xsl:otherwise>
</xsl:choose>
</tr>
</xsl:for-each>
</table>

</body>
</html>
</xsl:template>
</xsl:stylesheet>
