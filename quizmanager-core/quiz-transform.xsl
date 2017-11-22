<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/quiz">
		<html>
			<head>
				<title>
					<xsl:value-of select="@name" />
				</title>
			</head>
			<body>
				<h1>
					Welcome to the Quiz :
					<xsl:value-of select="@name" />
				</h1>
				<xsl:apply-templates select="question" />
			</body>
		</html>

	</xsl:template>


	<xsl:template match="question">
		<div>
			<h2>
				<xsl:apply-templates select="text" />
			</h2>
			<xsl:apply-templates select="option" />
		</div>

	</xsl:template>

	<xsl:template match="text">
		<xsl:value-of select="./text()" />
	</xsl:template>

	<xsl:template match="option">
		<div>
			<xsl:variable name="position" select="position()"></xsl:variable>
			<label>
				<xsl:value-of select="label/text()" />
			</label>
			<input type="checkbox">
				<xsl:attribute name="value"><xsl:value-of select="$position" /></xsl:attribute>

			</input>
		</div>

	</xsl:template>


</xsl:stylesheet>