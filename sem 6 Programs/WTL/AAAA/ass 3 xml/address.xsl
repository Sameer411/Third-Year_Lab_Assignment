<?xml version = "1.0" encoding = "UTF-8"?>
<xsl:stylesheet version = "2.0"
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>xml and xsl</title>
<style>
            tr:nth-child(even) {background: white}
            tr:nth-child(odd) {background: aliceblue}
</style>
</head>

	<body>
		<h2 style="text-align: center;text-decoration: underline;">Alumni Address Book</h2>
		<table cellpadding="10" border="1">
		<tr>
		<th>id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Contact</th>
		<th>E-mail</th>
		</tr>
	

		<xsl:for-each select="Address_Book/alumni">
		<xsl:sort select="name"/>
		<tr>
		<td><xsl:value-of select= "@id"/></td>
		<td><xsl:value-of select="name"/></td>
		<td><xsl:value-of select="address"/></td>
		<td><xsl:value-of select="contact"/></td>
		<td><xsl:value-of select="email"/></td>
		</tr>
		
		</xsl:for-each>
		</table>
		</body>
		</html>
		</xsl:template>
		</xsl:stylesheet>
