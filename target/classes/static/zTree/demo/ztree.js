/*树形菜单演示数据*/
var menudata = [
    {
        name: "父节点1", children: [
            {name: "子节点1"},
            {name: "子节点2"}
        ]
    }
];
var nodes = [
    {id: 1, pid: 0, name: "父节点1"},
    {id: 11, pid: 1, name: "子节点1"},
    {id: 12, pid: 1, name: "子节点2"}
];