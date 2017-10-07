namespace java com.andyadc.thrift.service

include "dto.thrift"

service HelloService {

    string ping(),

    list<dto.User> getUserList(1:dto.UserReq req)
}