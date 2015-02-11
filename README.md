# Pelias scripts

Scripts (mostly written in groovy) that needs to be dropped in elasticsearch/config folder when used with pelias-api search queries that uses scripting.

Scripts are written to disk primarily to [avoid dynamic scripting](http://www.elasticsearch.org/blog/running-groovy-scripts-without-dynamic-scripting/). 

You could symlink this to your local elasticsearch config directory like so..

```
	ln -s scripts/ /path/to/elasticsearch/config/scripts	 
```

Or just place it in the ```config/scripts``` directory.

If these file were placed in the ```config/scripts``` directory of all of your Elasticsearch data nodes, then Elasticsearch will pick up the script within 60 seconds (configurable by [changing watcher.interval](http://www.elasticsearch.org/guide/en/elasticsearch/reference/current/modules-scripting.html#_automatic_script_reloading) in your elasticsearch.yml) and pre-compile it for use with future requests. You do need to ensure that the file is readable by the user running Elasticsearch! After writing this to disk, your configuration directory should look something like this:

```
config/
  elasticsearch.yml
  logging.yml
  scripts/
    population.groovy
    weights.groovy
```

Your script will not be usable until the script is loaded, at which point you will see something like this in your log file(s):

```
[2015-02-11 11:14:47,066][INFO ][script                   ] [The Hulk] compiling script file [/path/to/elasticsearch-1.4.3/config/scripts/population.groovy]
[2015-02-11 11:15:47,066][INFO ][script                   ] [The Hulk] compiling script file [/path/to/elasticsearch-1.4.3/config/scripts/weights.groovy]
```

Once the scripts has been loaded by all of your Elasticsearch data nodes, then you can begin to use it. 