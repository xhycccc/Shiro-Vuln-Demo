# Shiro-Vuln-Demo
Shiro漏洞实例源码

## Shiro反序列化系列
1. Shiro-550
2. Shiro-721

## Shiro权限绕过系列
| CVE            | 描述                   | payload举例    |
| -------------- | ---------------------- | -------------- |
| CVE-2020-1957  | 权限绕过               | /hello/123/    |
| CVE-2020-11989 | CVE-2020-1957补丁绕过  | /;/admin/page  |
| CVE-2020-13933 | CVE-2020-11989补丁绕过 | /admin/%3bpage |

