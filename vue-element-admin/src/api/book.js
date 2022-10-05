import request from '@/utils/request'

export function list(currentPage, pageSize, data){
  return request({
    url: '/book/list' + '/' + currentPage + '/' + pageSize,
    method: 'POST',
    data
  })
}
