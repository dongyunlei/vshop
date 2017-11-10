vshop = {

    registerMenuEvent: function () {
        var $tree = $('#menu .easyui-tree');
        $tree.tree({
            onClick: function (node) {
                var href = node.attributes.href;
                $('#tab').tabs('add', {
                    title: node.text,
                    href: href,
                    closable: true
                });
            }
        });
    }
};
