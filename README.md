# Spring Security 4 Tutorials
<h2>Recommended system requirements:</h2>
<ul>
	<li><a href="https://www.eclipse.org/downloads/packages/release/Luna/SR2" target="_blank">Eclipse Luna 4.4.2</a></li>
	<li><a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html" target="_blank">JDK 8</a></li>
	<li><a href="https://tomcat.apache.org/download-80.cgi" target="_blank">Tomcat 8</a></li>
</ul>
<h2>Spring Security XML-based project</h2>
<ul>
	<li>
		<h3>Using the default login form</h3>
		<ul>
			<li>
				<h4>Technologies used:</h4>
				<ul>
					<li>Maven 4.0.0</li>
					<li>Spring Security 4.2.0.RELEASE</li>
					<li>JSP Standard Tag Library 1.2</li>
					<li>Apache Commons Logging 1.2</li>
				</ul>
			</li>
			<li>
				<h4>Download:</h4>
				<ul>
					<li><a href="https://github.com/prongbang/spring-security/releases/tag/v1.0.0" target="_blank">Source Code</a></li>
				</ul>
			</li>
		</ul>
	</li>
	<li>
		<h3>Using the default login form</h3>
		<ul>
			<li>
				<h4>Technologies used:</h4>
				<ul>
					<li>Maven 4.0.0</li>
					<li>Spring 4.3.4.RELEASE</li>
					<li>Spring Security 4.2.0.RELEASE</li>
					<li><a href="http://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html" target="_blank">Thymeleaf-Spring 3.0.0.RELEASE</a></li>
					<li><a href="https://github.com/thymeleaf/thymeleaf-extras-springsecurity" target="_blank">Thymeleaf-Extras-Springsecurity4 3.0.0.RELEASE</a></li>
					<li>Apache Commons Logging 1.2</li>
					<li>Slf4j-nop 1.7.21</li>
				</ul>
			</li>
			<li>
				<h4>Role:</h4>
				<ul>
					<li>User</li>
					<li>Admin</li>
					<li>Dba</li>
				</ul>
			</li>
			<li>
				<h4>Download:</h4>
				<ul>
					<li><a href="https://github.com/prongbang/spring-security/releases/tag/v1.0.1" target="_blank">Source Code</a></li>
				</ul>
			</li>
		</ul>
	</li>
	<li>
		<h3>Custom login form and error code</h3>
		<ul>
			<li>
				<h4>Technologies used:</h4>
				<ul>
					<li>Maven 4.0.0</li>
					<li>Spring 4.3.4.RELEASE</li>
					<li>Spring Security 4.2.0.RELEASE</li>
					<li><a href="http://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html" target="_blank">Thymeleaf-Spring 3.0.0.RELEASE</a></li>
					<li><a href="https://github.com/thymeleaf/thymeleaf-extras-springsecurity" target="_blank">Thymeleaf-Extras-Springsecurity4 3.0.0.RELEASE</a></li>
					<li>Apache Commons Logging 1.2</li>
					<li>Slf4j-nop 1.7.21</li>
				</ul>
			</li>
			<li>
				<h4>Add new:</h4>
				<ul>
					<li>
						<h4>Custom Login:</h4>
						<ul>
							<li>
								<h5>Create Login Controller</h5>
								<ul>
									<li>src/main/java/com/prongbang/sec/controller/LoginController.java</li>
								</ul>
							</li>
							<li>
								<h5>Create Login Page</h5>
								<ul>
									<li>src/main/webapp/WEB-INF/templates/login.html</li>
								</ul>
							</li>
						</ul>
					</li>
					<li>
						<h4>Custom Error:</h4>
						<ul>
							<li>
								<h5>Create Error Controller</h5>
								<ul>
									<li>src/main/java/com/prongbang/sec/controller/ErrorController.java</li>
								</ul>
							</li>
							<li>
								<h5>Add error code</h5>
								<ul>
									<li>src/main/webapp/WEB-INF/web.xml</li>
								</ul>
							</li>
						</ul>
					</li>
					<li><h4>Spring Security Remember me</h4></li>
				</ul>
			</li>
			<li>
				<h4>Role:</h4>
				<ul>
					<li>User</li>
					<li>Admin</li>
					<li>Dba</li>
				</ul>
			</li>
			<li>
				<h4>Download:</h4>
				<ul>
					<li><a href="https://github.com/prongbang/spring-security/releases/tag/v1.0.2" target="_blank">Source Code</a></li>
				</ul>
			</li>
		</ul>
	</li>
	<li>
		<h3>Custom login using database – MySQL</h3>
		<ul>
			<li>
				<h4>Technologies used:</h4>
				<ul>
					<li>Maven 4.0.0</li>
					<li>Spring 4.3.4.RELEASE</li>
					<li>Spring Security 4.2.0.RELEASE</li>
					<li>Spring Jdbc 4.3.4.RELEASE</li>
					<li>Mysql Connector Java 6.0.5</li>
					<li><a href="http://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html" target="_blank">Thymeleaf-Spring 3.0.0.RELEASE</a></li>
					<li><a href="https://github.com/thymeleaf/thymeleaf-extras-springsecurity" target="_blank">Thymeleaf-Extras-Springsecurity4 3.0.0.RELEASE</a></li>
					<li>Apache Commons Logging 1.2</li>
					<li>Slf4j-nop 1.7.21</li>
				</ul>
			</li>
			<li>
				<h4>Add new:</h4>
				<ul>
					<li>
						<h4>Custom login using database</h4>
					</li>
				</ul>
			</li>
			<li>
				<h4>Role:</h4>
				<ul>
					<li>User</li>
					<li>Admin</li>
					<li>Dba</li>
				</ul>
			</li>
			<li>
				<h4>Download:</h4>
				<ul>
					<li><a href="https://github.com/prongbang/spring-security/releases/tag/v1.0.3" target="_blank">Source Code</a></li>
				</ul>
			</li>
		</ul>
	</li>
</ul>
