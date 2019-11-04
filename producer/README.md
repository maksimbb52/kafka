# Demo producer for demonstrating messaging with kafka
# If you want to send post, put, delete requests to server, you need to get a csrf token from this server by sending

# curl -v 'http://localhost:8091/producer/security/csrf' -u user:<generated password by spring security>

# Then you can send get-requests without username and password, but with header Cookie:JSESSIONID=<generated session by server>
# If you want to send other requests, also you need to add header "X-CSRF-TOKEN:<returned value of csrf>"
#
# Example of post-request:
# curl -v -X POST 'http://localhost:8091/producer/rate/newRates' \
# -H "Cookie:JSESSIONID=7DB1BB15FBEBEB6A5467D974BF30C822" \
# -H "X-CSRF-TOKEN:1148e00d-814a-4a5e-996c-0018e48a28b5" \
# -H "Content-Type:application/json"  \
# -d '[{ \
#       "id": "", \
#        "currency": { \
#            "id": "1", \
#            "name": "dollar" \
#         }, \ 
#         "price": "66.77", \ 
#         "date": "2019-02-05", \ 
#         "time": "22:08:29.097869" \
#     }, \ 
#     { \
#         "id": "", \ 
#         "currency": { \
#            "id": "1", \ 
#            "name": "dollar" \
#         }, \ 
#         "price": "64.99", \ 
#        "date": "2019-02-06", \ 
#         "time": "21:08:29.097869" \
#     }]' \
#
# The same request in one line:
# curl -v 'http://localhost:8091/producer/rate/newRates' -H "Cookie:JSESSIONID=7DB1BB15FBEBEB6A5467D974BF30C822" -H "X-CSRF-TOKEN:1148e00d-814a-4a5e-996c-0018e48a28b5" -X POST -H "Content-Type:application/json" -d '[{"id": "", "currency": {"id": "1", "name": "dollar"}, "price": "66.77", "date": "2019-02-05", "time": "22:08:29.097869"}, {"id": "", "currency": {"id": "1", "name": "dollar"}, "price": "64.99", "date": "2019-02-06", "time": "21:08:29.097869"}]'