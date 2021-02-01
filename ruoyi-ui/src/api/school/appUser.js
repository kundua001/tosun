import request from '@/utils/request'

// 查询用户信息列表
export function listAppUser(query) {
  return request({
    url: '/api/appUser/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息详细
export function getAppUser(id) {
  return request({
    url: '/api/appUser/' + id,
    method: 'get'
  })
}

// 新增用户信息
export function addAppUser(data) {
  return request({
    url: '/api/appUser',
    method: 'post',
    data: data
  })
}

// 修改用户信息
export function updateAppUser(data) {
  return request({
    url: '/api/appUser',
    method: 'put',
    data: data
  })
}

// 删除用户信息
export function delAppUser(id) {
  return request({
    url: '/api/appUser/' + id,
    method: 'delete'
  })
}
