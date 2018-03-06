## NewsApiImpl ##

**How to build the project**

Prerequisites:
* Tomcat 9.0.5 - [link](https://tomcat.apache.org/download-90.cgi) 
* Apache Maven 3.5.2 - [link](https://maven.apache.org/download.cgi)
* Java 8 (jdk1.8.0_45)

Preparing war file:
Go to project root directory (~\NewsApiImpl) and execute operation:

```
mvn install
```
war file will be created in directory:

```
~\NewsApiImpl\target\
```
filename: **NewsApiImpl.war**

Deploy project in tomcat server:
To deploy project simply copy war file to 

```
~\apache-tomcat-9.0.5\webapps\
```
*~\apache-tomcat-9.0.5* - place where tomcat server had been installed.

Web Service will be available under:

```
http://localhost:8080/NewsApiImpl/restservices/news/pl/technology
```

*http://localhost:8080* - address where tomcat server is visible, depend on server configuration  

------------------------
**Using of NewsApiImpl**

Root path is : NewsApiImpl/restservices/news/{lang}/{category}?pageSize&page
Method GET

```
Parameters
lang     - The 2-letter ISO 3166-1 code of the country you want to get headlines for. 
           Possible options are listed on https://newsapi.org/docs/endpoints/top-headlines - country parameter.
category - The category you want to get headlines for.
           Possible options are listed on https://newsapi.org/docs/endpoints/top-headlines - category parameter.
pageSize - The number of results to return per page (request). 20 is the default, 100 is the maximum.
page     - Use this to page through the results if the total results found is greater than the page size.
```
Sample execution: http://localhost:8080/NewsApiImpl/restservices/news/pl/technology?pageSize=2&page=5

Returned structure:

```
{
  category: string,
  country: string,
  articles: {
    articleUrl: string,
    author: string,
    date: string(yyyy-MM-dd),
    description: string,
    imageUrl: string,
    sourceName: string,
    title: string
  }[]
}
```
