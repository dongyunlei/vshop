vshop = {

    registerMenuEvent: function () {
        var _this = this;
        var $tree = $('#menu .easyui-tree');
        $tree.tree({
            onClick: function (node) {
                var href = node.attributes.href;
                var text = node.text;
                _this.addTabs(href, text);
            }
        });
    },
    addTabs: function (href, text) {
        if($('#tab').tabs('exists',text)){
            $('#tab').tabs('select',text)
        }else{
            $('#tab').tabs('add', {
                title: text,
                href: href,
                closable: true
             });
        }

    }
};

