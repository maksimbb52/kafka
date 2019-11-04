# Demo producer for demonstrating messaging with kafka
# If you want to send post, put, delete requests to server, you need to get a csrf token from this server by sending

# curl -v 'http://localhost:8092/consumer/security/csrf' -u user:<generated password by spring security>

# Then you can send get-requests without username and password, but with header Cookie:JSESSIONID=<generated session by server>
# If you want to send other requests, also you need to add header "X-CSRF-TOKEN:<returned value of csrf>"
#
# Example of post-request:
# curl -v -X POST 'http://localhost:8092/consumer/statistic/newStatistics' \ 
# -H "Cookie:JSESSIONID=FABD9C3C7DA716A9BBDE4AE5498121FA" \ 
# -H "X-CSRF-TOKEN:68763e1b-b125-4dda-8276-ea59dbe6cb6d" \
# -H "Content-Type:application/json" \ 
# -d '[{ \
#       "id": "", \
#       "fromDt": "2019-02-05T22:08:28.097832", \ 
#       "toDt": "2019-04-05T22:08:28.097832", \
#       "average": "77.7777", \
#       "isGreater": "false" \
#   }, \
#   { \
#       "id": "", \ 
#       "fromDt": \ 
#       "2019-03-05T22:08:28.097832", \ 
#       "toDt": "2019-05-05T22:08:28.097832", \ 
#       "average": "88.888", \ 
#       "isGreater": "true" \
#   }]'
#
# The same request in one line:
# curl -v 'http://localhost:8092/consumer/statistic/newStatistics' -H "Cookie:JSESSIONID=FABD9C3C7DA716A9BBDE4AE5498121FA" -H "X-CSRF-TOKEN:68763e1b-b125-4dda-8276-ea59dbe6cb6d" -X POST -H "Content-Type:application/json" -d '[{"id": "", "fromDt": "2019-02-05T22:08:28.097832", "toDt": "2019-04-05T22:08:28.097832", "average": "77.7777", "isGreater": "false"}, {"id": "", "fromDt": "2019-03-05T22:08:28.097832", "toDt": "2019-05-05T22:08:28.097832", "average": "88.888", "isGreater": "true"}]'
