alter table produtos add tipoprato_id int;

alter table produtos add constraint FK_produtos_category
foreign key (tipoprato_id) references tipoprato(id);