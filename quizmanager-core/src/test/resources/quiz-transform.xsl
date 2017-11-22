<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/quiz">
		<html>
			<head>
				<style>
					.hidden {
					display:none;
					}

					.explanation {
					display:inital;
					}

					.valid{
					color: green;
					}

					.invalid{
					color: red;
					}
				</style>


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

				<script>

				</script>
			</body>
		</html>

	</xsl:template>


	<xsl:template match="question">
		<div>
			<h2>
				<xsl:call-template name="questionTextTemplate" />
			</h2>
			<xsl:apply-templates select="option" />
		</div>

	</xsl:template>

	<xsl:template name="questionTextTemplate">
		<xsl:value-of select="text/text()" />
	</xsl:template>

	<xsl:template match="explanation">

		<span class="hidden">
			<xsl:value-of select="text()" />
		</span>


	</xsl:template>

	<xsl:template match="option">
		<div>
			<xsl:choose>
				<xsl:when test="@valid = 'true'">
					<xsl:attribute name="class">valid</xsl:attribute>
				</xsl:when>
				<xsl:otherwise>
					<xsl:attribute name="class">invalid</xsl:attribute>
				</xsl:otherwise>
			</xsl:choose>
			<xsl:variable name="position" select="position()"></xsl:variable>
			<label>
				<xsl:value-of select="label/text()" />
			</label>
			<input type="checkbox">
				<xsl:attribute name="value"><xsl:value-of select="$position" /></xsl:attribute>

			</input>

		</div>
		<xsl:apply-templates select="explanation" />
	</xsl:template>


</xsl:stylesheet>