namespace java com.andyadc.thrift.dto

struct User {
  1: i16 age = 0,
  2: string name
}

struct UserReq {
    1: string name
}